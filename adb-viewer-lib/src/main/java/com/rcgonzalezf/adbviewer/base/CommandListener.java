package com.rcgonzalezf.adbviewer.base;

public interface CommandListener<S,F> {

    void onSuccess(S successType);

    void onFailure(F failureType);
}
