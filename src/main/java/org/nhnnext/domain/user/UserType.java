package org.nhnnext.domain.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {
    LOCAL(Values.LOCAL),
    GITHUB(Values.GITHUB);

    private final String value;

    public static class Values {
        public static final String LOCAL = "L";
        public static final String GITHUB = "G";
    }
}
