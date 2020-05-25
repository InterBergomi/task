package com.example.task.util;

import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.util
 * @description:
 * @createTime: 2020-05-24 08:53
 */
public class ListUtils {

    public static <F, T> List<T> srcListToDesList(List<F> srcList, Class<T> desClass) {
        if (srcList.isEmpty() || srcList == null) {
            return new ArrayList<T>();
        }
        List<T> desList = new ArrayList<>();
        for (F srcListItem : srcList) {
            T desListItem = srcToDes(srcListItem, desClass);
            desList.add(desListItem);
        }
        return desList;
    }

    public static <F, T> T srcToDes(F srcItem, Class<T> desClass) {
        // srcToDes : Src属性的值赋值到Des
        Object desObject = null;
        if (srcItem == null || desClass == null) {
            return null;
        }

        try {
            desObject = desClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(srcItem, desObject);
        return (T) desObject;
    }

    public static <T> T deepCopyWithSerialize(T target) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        T result = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(target);
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            result = (T)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ois) {
                    ois.close();
                }
                if (null != bais) {
                    bais.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
