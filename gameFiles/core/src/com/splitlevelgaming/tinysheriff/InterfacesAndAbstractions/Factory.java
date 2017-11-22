package com.splitlevelgaming.tinysheriff;

interface Factory<T> {
    T buildOne(String directory);
}
