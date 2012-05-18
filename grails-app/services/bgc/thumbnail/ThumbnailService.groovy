package bgc.thumbnail

class ThumbnailService {
  static transactional = true

  def burningImageService

  def getThumbnail(def id, def width, def height) {
    def result = Thumbnail.withCriteria {
      or {
        and {
          eq('id', id)
          if (width && width > 0)   eq('width', width)
          if (height && height > 0) eq('height', height)
        }
        and {
          eq('parentImage.id', id)
          if (width && width > 0)   eq('width', width)
          if (height && height > 0) eq('height', height)
        }
      }
    }
    
    if (result) {
      return result[0]
    } else {
      def parentImage = Thumbnail.get(id)
      def aspectRatio = (parentImage.width as float) / (parentImage.height as float)
      def newHeight   = (width / aspectRatio) as int
      
      def tempDir = System.getProperty("java.io.tmpdir")
      def newImg
      
      def tempFile = File.createTempFile("img_", parentImage.filename)
      tempFile.withOutputStream { s -> 
        s << parentImage.image 
      }
      
      burningImageService.doWith(tempFile.absolutePath, tempDir).execute {
        it.scaleAccurate(width, newHeight)
      }
      
      def newImage = new Thumbnail(
        image:       new File(tempDir, tempFile.getName()).bytes, 
        filename:    parentImage.filename, 
        width:       width, 
        height:      height, 
        parentImage: parentImage).save()
        
      return newImage
    }
  }
  
  def saveThumbnail(imgFile) {
    def thumbnail = new Thumbnail()
    def tempDir   = System.getProperty("java.io.tmpdir")
    
    // Sets the image bytes
    thumbnail.image = imgFile.bytes
    // Sets the filename
    thumbnail.filename = imgFile.getOriginalFilename()
    // Gets the image dimensions (width and height)
    burningImageService.doWith(imgFile, tempDir).execute {
      def img = it.loadedImage.getAsJaiStream()
      thumbnail.width  = img.width
      thumbnail.height = img.height
    }
    
    return thumbnail.save(flush: true, failOnError: true)
  }
}
