package org.immutable.test;

import java.util.List;
import org.immutables.value.Value;

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
