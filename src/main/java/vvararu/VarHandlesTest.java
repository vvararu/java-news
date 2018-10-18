package vvararu;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandlesTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Container container = new Container();


        // - Simple read/write access to a private int attribute
        VarHandle handle = MethodHandles
                .privateLookupIn(Container.class, MethodHandles.lookup())
                .findVarHandle(Container.class, "privateIntVar", int.class);

        handle.set(container, 20);

        // setting a value to the private int attribute
        handle.set(container, 20);

        // getting the value of the private int attribute
        System.out.println(handle.get(container));


        //------------------------------------------------------------------------------------


        // - Simple read access to a private int[] element
        VarHandle privateArrayHandle = MethodHandles
                .privateLookupIn(Container.class, MethodHandles.lookup())
                .findVarHandle(Container.class, "privateArray", int[].class);

        System.out.println(((int[]) privateArrayHandle.get(container))[1]);

    }

}

class Container {

    private int privateIntVar = 1;

    private int[] privateArray = new int[]{1, 2, 3};

}
