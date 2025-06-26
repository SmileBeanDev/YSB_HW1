package dev.smilebean.ysb_hw1.annotation;

import lombok.Getter;

@Getter
public enum GqlType {
    QUERY("Query"), MUTATION("Mutation");

    private String value;

    GqlType(String value) {
        this.value = value;
    }
}
