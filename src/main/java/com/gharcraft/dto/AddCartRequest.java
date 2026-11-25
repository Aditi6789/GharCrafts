package com.gharcraft.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
public record AddCartRequest(@NotNull Long productId, @Min(1) int quantity) {}
