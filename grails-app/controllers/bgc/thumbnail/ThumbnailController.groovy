package bgc.thumbnail

class ThumbnailController {
  def burningImageService
  def thumbnailService

  def show = {
      def thumbnail = Thumbnail.get(params.id)
      def width     = params.width  ? Integer.parseInt(params.width as String)  : thumbnail.width
      def height    = params.height ? Integer.parseInt(params.height as String) : thumbnail.height
    
      response.outputStream << thumbnailService.getThumbnail(thumbnail.id, width, height).image
      response.outputStream.flush()
  }
}
