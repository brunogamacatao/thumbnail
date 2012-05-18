import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

import bgc.thumbnail.Thumbnail
import bgc.thumbnail.ThumbnailEditor

public class ThumbnailEditorRegistrar implements PropertyEditorRegistrar {
  def thumbnailService

  public void registerCustomEditors(PropertyEditorRegistry registry) {
    registry.registerCustomEditor(Thumbnail, new ThumbnailEditor(thumbnailService))
  }
}