package com.khepri.black.command;

public enum CommandType {
    EXECUTOR {
        @Override
        public ICommand create(String name) {
            ICommand command = new ExecutorCommand();
            command.setName(name);
            return command;
        }
    };

    public abstract ICommand create(String name);
}
