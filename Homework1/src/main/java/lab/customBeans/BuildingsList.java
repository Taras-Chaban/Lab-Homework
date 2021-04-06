package lab.customBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingsList {
    private List<Building> buildingList;

    @Autowired
    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public void printBuildings() {
        for (Building building : buildingList) {
            System.out.println(building);
        }
    }
}
