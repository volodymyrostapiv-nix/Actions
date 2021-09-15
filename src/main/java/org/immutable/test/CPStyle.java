package org.immutable.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.immutables.value.Value;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS) // Make it class retention for incremental compilation
@Value.Style(
    typeAbstract = "*IF",
    typeImmutable = "*",
    redactedMask = " #redacted# ",
    stagedBuilder = true,
    depluralize = true,
    strictBuilder = false)
public @interface CPStyle {}
