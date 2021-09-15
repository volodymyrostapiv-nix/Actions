package org.immutable.test;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@CPStyle
public interface StyledUserIF {
  @Value.Parameter
  String getUsername();

  @Value.Redacted
  @Value.Parameter
  String getPassword();

  @Value.Derived
  default long getCreatedAt() {
    return System.currentTimeMillis();
  }

  @Value.Lazy
  default long getAccessedAt() {
    return System.currentTimeMillis();
  }

  List<Integer> getNumbers();
}
