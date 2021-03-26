package myappaledone.myappale.data.entity;


import myappaledone.myappale.commons.Mapper;
import myappaledone.myappale.commons.generator.StringGridGenerator;
import myappaledone.myappale.data.entity.GameDataEntity;
import myappaledone.myappale.model.GameData;
import myappaledone.myappale.model.Grid;



public class GameDataMapper extends Mapper<GameDataEntity, GameData> {
    @Override
    public GameData map(GameDataEntity obj) {
        if (obj == null) return null;

        Grid grid = new Grid(obj.getGridRowCount(), obj.getGridColCount());
        GameData gr = new GameData();
        gr.setId(obj.getId());
        gr.setName(obj.getName());
        gr.setDuration(obj.getDuration());
        gr.setGrid(grid);

        if (obj.getGridData() != null && obj.getGridData().length() > 0) {
            new StringGridGenerator().setGrid(obj.getGridData(), grid.getArray());
        }

        gr.addUsedWords(obj.getUsedWords());

        return gr;
    }

    @Override
    public GameDataEntity revMap(GameData obj) {
        if (obj == null) return null;

        GameDataEntity ent = new GameDataEntity();
        ent.setId(obj.getId());
        ent.setName(obj.getName());
        ent.setDuration(obj.getDuration());

        if (obj.getGrid() != null) {
            ent.setGridRowCount(obj.getGrid().getRowCount());
            ent.setGridColCount(obj.getGrid().getColCount());
            ent.setGridData(obj.getGrid().toString());
        }

        ent.setUsedWords(obj.getUsedWords());

        return ent;
    }
}
