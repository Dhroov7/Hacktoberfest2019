-module(helloWorld).
-export([hello/0]).

hello() ->
    io:format("Hello World~n").
