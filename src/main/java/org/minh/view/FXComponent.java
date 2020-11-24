package org.minh.view;

import javafx.scene.Parent;

public interface FXComponent {
  /** Renders the component and returns the resulting Parent object */
  Parent render();
}