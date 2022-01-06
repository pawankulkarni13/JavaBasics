### Repeatable Annotation
To define a repeatable annotation, you must create a container annotation for the list of repeatable annotations and designate a repeatable meta annotation @Repeatable:
    
    @interface  Schedulers {
        Scheduler [] value ();
    }
    @Repeatable ( Schedulers . Class)
     @interface  Scheduler {
        String  birthday () default "Jan 8 2000";
    }
    
