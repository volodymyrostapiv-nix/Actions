package org.immutable.test;

import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(
    typeAbstract = "*IF",
    typeImmutable = "*",
    redactedMask = " #redacted# ",
    defaultAsDefault = true)
public interface UserIF {
  @Value.Parameter
  String getUsername();

  @Value.Redacted
  @Value.Parameter
  String getPassword();

  // @Value.Default not needed due to defaultAsDefault = true
  default String getAvatarPath() {
    return "htttp://avatars/default.jpg";
  }

  @Value.Auxiliary
  Optional<Integer> getSalt();

  @Value.Check
  default void check() {
    if (getPassword().contains("qwert")) throw new RuntimeException("The password is too simple!");
  }
}
