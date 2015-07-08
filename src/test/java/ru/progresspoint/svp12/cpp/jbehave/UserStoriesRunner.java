package ru.progresspoint.svp12.cpp.jbehave;

import ru.progresspoint.svp12.LocalizedUserStories;

public class UserStoriesRunner extends LocalizedUserStories {

    @Override
    protected String rootPackage() {
        return "ru.progresspoint.svp12.cpp.jbehave.steps";
    }
}
