package it.rciovati.designlibrarydemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.view.View;

public class ExampleBehaviour extends Behavior<FloatingActionButton> {

  @Override
  public boolean layoutDependsOn(final CoordinatorLayout parent, final FloatingActionButton child,
      final View dependency) {

    return dependency instanceof Snackbar.SnackbarLayout;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child,
      View dependency) {

    if (dependency instanceof Snackbar.SnackbarLayout) {
      float dependencyTranslationY = ViewCompat.getTranslationY(dependency);
      float translationY = Math.min(0, dependencyTranslationY - dependency.getHeight());
      ViewCompat.animate(child).translationY(translationY);
      return true;
    }

    return false;
  }
}
