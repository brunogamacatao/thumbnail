package bgc.thumbnail

class ThumbnailTagLib {
  def thumbnail = { attrs ->
    def myParams = [:]
    if (attrs.width)  myParams['width']  = attrs.width
    if (attrs.height) myParams['height'] = attrs.height
    
    out << "<img src='"
    out << g.createLink(
      action: "show", 
      controller: "thumbnail", 
      id: attrs.id, 
      params: myParams)
    out << "'"
    
    if (attrs['class'])
      out << " class='${attrs['class']}'"
    
    out << "/>"
  }

}
