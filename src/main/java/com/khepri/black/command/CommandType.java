package com.khepri.black.command;

public enum CommandType {
    EXECUTOR {
        @Override
        public ICommand create() {
            return new ExecutorCommand();
        }
    };

    public abstract ICommand create();
}
