package lab.customBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingsList {
    private List<Building> buildingList;

    private Building cottage;
    private Building house;
    private Building tower;
    private Building warehouse;

    public Building getCottage() {
        return cottage;
    }

    public Building getHouse() {
        return house;
    }

    public Building getTower() {
        return tower;
    }

    public Building getWarehouse() {
        return warehouse;
    }

    @Autowired
    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    @Autowired
    public void setCottage(Building cottage) {
        this.cottage = cottage;
    }

    @Autowired
    @Qualifier("house")
    public void setHouse(Building house) {
        this.house = house;
    }

    @Autowired
    @Qualifier("tower")
    public void setTower(Building tower) {
        this.tower = tower;
    }

    @Autowired
    @Qualifier("warehouse")
    public void setWarehouse(Building warehouse) {
        this.warehouse = warehouse;
    }

    public void printBuildings() {
        for (Building building : buildingList) {
            System.out.println(building);
        }
    }

}
