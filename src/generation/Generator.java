package generation;

import cell.CellHolder;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class Generator
{

    CellHolder cell = new CellHolder();
    EnemyGeneration enemy = new EnemyGeneration();
    LandGeneration land = new LandGeneration();
    ResourceGeneration resource = new ResourceGeneration();

    public void generateDefault()
    {
        land.layGrass();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.forest();
        land.desert();
        land.desert();
        land.water();
        land.water();
        land.mountian();
        land.mountian();
        land.mountian();
        land.mountian();
        startP(19, 19);
        resource.fertility();
        resource.mining();
        resource.lumber();
        //start enemy creation
        enemy.populate();
    }

    public void startP(int x, int y) //-1
    {
        cell.getCell(x, y).setBiome(-1);
        cell.getCell(x - 1, y - 0).setBiome(0);
        cell.getCell(x - 1, y - 1).setBiome(0);
        cell.getCell(x - 0, y - 0).setBiome(0);
        cell.getCell(x, y).visible().setAllVisible(true);
        cell.getCell(x - 1, y - 0).visible().setAllVisible(true);
        cell.getCell(x - 1, y - 1).visible().setAllVisible(true);
        cell.getCell(x - 0, y - 0).visible().setAllVisible(true);
        cell.getCell(x, y).owned().setOwned(true);

    } //end method
}
