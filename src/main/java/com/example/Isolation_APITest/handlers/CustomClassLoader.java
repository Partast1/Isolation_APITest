package com.example.Isolation_APITest.handlers;
import Services.LocationService;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CustomClassLoader<LocationService> extends ClassLoader {

    public LocationService LoadClass(String directory, String classpath, Class<LocationService> parentClass) throws ClassNotFoundException {
        File pluginsDir = new File(System.getProperty("user.dir") + directory);
        for (File jar : pluginsDir.listFiles()) {
            try {
                ClassLoader loader = URLClassLoader.newInstance(
                        new URL[] { jar.toURL() },
                        getClass().getClassLoader()
                );
                Class<?> clazz = Class.forName(classpath, true, loader);
                Class<? extends LocationService> newClass = clazz.asSubclass(parentClass);
                // Apparently its bad to use Class.newInstance, so we use
                // newClass.getConstructor() instead
                Constructor<? extends LocationService> constructor = newClass.getConstructor();
                return constructor.newInstance();

            } catch (ClassNotFoundException e) {
                // There might be multiple JARs in the directory,
                // so keep looking
                continue;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new ClassNotFoundException("Class " + classpath
                + " wasn't found in directory " + System.getProperty("user.dir") + directory);
    }

//    @Override
//    public Class<?> findClass(String name) {
//        byte[] bt = loadClassData(name);
//        return defineClass(name, bt, 0, bt.length);
//    }
//    private byte[] loadClassData(String className) {
//        //read class
//        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
//        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
//        //write into byte
//        int len =0;
//        try {
//            while((len=is.read())!=-1){
//                byteSt.write(len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //convert into byte array
//        return byteSt.toByteArray();
//    }
//
//    @Override
//    public Class findClass(String name) throws ClassNotFoundException {
//        byte[] b = loadClassFromFile(name);
//        return defineClass(name, b, 0, b.length);
//    }
//    private byte[] loadClassFromFile(String fileName)  {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
//                fileName.replace('.', File.separatorChar) + ".class");
//        byte[] buffer;
//        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//        int nextValue = 0;
//        try {
//            while ( (nextValue = inputStream.read()) != -1 ) {
//                byteStream.write(nextValue);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        buffer = byteStream.toByteArray();
//        return buffer;
//    }

}
