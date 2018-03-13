package org.freedesktop.appstream;

import java.util.Optional;
import org.freedesktop.appstream.appdata.Image;
import org.freedesktop.appstream.appdata.Screenshot;

public class ScreenshotInfo extends Screenshot{

  public ScreenshotInfo() {
    super();
  }

  public ScreenshotInfo(Screenshot parentScreenshot) {
    super();
    this.image = parentScreenshot.getImage();
    this.type = parentScreenshot.getType();
  }


  public Optional<String> findThumbnailUrlByHeight(short height){

    for (Image image: this.getImage()) {
      if(AppdataComponent.SCREENSHOT_IMAGE_TYPE_THUMBNAIL.equalsIgnoreCase(image.getType())){
        if(image.getHeight() == height) return Optional.ofNullable(image.getValue());
      }
    }

    return Optional.empty();
  }

}
