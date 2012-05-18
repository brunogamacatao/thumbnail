package bgc.thumbnail

class Thumbnail {
  byte[] image
  String filename
  int width
  int height
  Thumbnail parentImage
  
  static constraints = {
    image(blank: false)
    filename(blank: false)
    width(blank: false)
    height(blank: false)
    parentImage(nullable: true)
  }
  
  static hasMany  = [thumbnails: Thumbnail]
  static mappedBy = [thumbnails: 'parentImage']
  static mapping = {
    image sqlType: 'longblob'
  }
}
