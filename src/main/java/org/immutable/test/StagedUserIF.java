package org.immutable.test;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(typeAbstract = "*IF", typeImmutable = "*", stagedBuilder = true, depluralize = true)
public interface StagedUserIF {
  @Value.Parameter
  String getUsername();

  @Value.Parameter
  org.immutable.test.Password getPassword();

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
