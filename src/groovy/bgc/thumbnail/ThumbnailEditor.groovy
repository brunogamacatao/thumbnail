package bgc.thumbnail

import java.io.IOException
import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor
import org.springframework.web.multipart.MultipartFile

import org.apache.commons.logging.LogFactory

import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

class ThumbnailEditor extends ByteArrayPropertyEditor {
  static final log = LogFactory.getLog(this)
  def thumbnailService
  def myValue
  
  public ThumbnailEditor(thumbnailService) {
    this.thumbnailService = thumbnailService
  }
  
  public void setValue(Object value) {
    if (value instanceof MultipartFile) {
      MultipartFile multipartFile = (MultipartFile) value
      try {
        myValue = thumbnailService.saveThumbnail(multipartFile)
      } catch (Exception ex) {
        myValue = null
      } catch (IOException ex) {
        IllegalArgumentException iae = new IllegalArgumentException("Cannot read contents of multipart file")
        iae.initCause(ex);
        throw iae;
      }      
    }
  }
  
  public Object getValue() {
    return myValue
  }
}