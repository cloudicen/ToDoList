create table if not exists taskList
(
    taskNo INTEGER not null
        constraint taskList_pk
            primary key autoincrement,
    isFinished INTEGER default 0 not null,
    taskInfo TEXT
);

create unique index if not exists taskList_taskID_uindex
    on taskList (taskNo);

