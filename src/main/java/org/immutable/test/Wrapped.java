package org.immutable.test;

import org.immutables.value.Value;

/** Just copy-pasted from samples: https://immutables.github.io/immutable.html#opaque-containers */

// declare style as meta annotation as shown
// or on package/top-level class
// This is just an example, adapt to your taste however you like
@Value.Style(
    // Detect names starting with underscore
    typeAbstract = "_*",
    // Generate without any suffix, just raw detected name
    typeImmutable = "*",
    // Make generated public, leave underscored as package private
    visibility = Value.Style.ImplementationVisibility.PUBLIC,
    // Seems unnecessary to have builder or superfluous copy method
    defaults = @Value.Immutable(builder = false, copy = false))
public @interface Wrapped {}

// base wrapper type
abstract class Wrapper<T> {
  @Value.Parameter
  public abstract T value();

  @Override
  public String toString() {
    return "## " + value() + " ##";
  }
}

@Value.Immutable
@Wrapped
abstract class _Password extends Wrapper<String> {
  @Override
  public String toString() {
    return "## " + value().substring(4, 8) + " ##";
  }
}
