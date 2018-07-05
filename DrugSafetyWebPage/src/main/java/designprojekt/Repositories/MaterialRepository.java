package designprojekt.Repositories;


import designprojekt.Entities.Material;
import jdk.nashorn.api.scripting.URLReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MaterialRepository {

    private List<Material> materials = new LinkedList<>();

    public void create(Material material) {
            materials.add(material);
    }

    public String read(String link) {
        return link;
    }

    public List<Material> readAll() {
        return materials;
    }

    public Material update(Material material) {
        for (Material m: materials) {
            materials.set(materials.indexOf(m), m);
        }
        return material;
    }

    public Material delete(Material material) {
        materials.remove(material);
        return material;
    }
}
