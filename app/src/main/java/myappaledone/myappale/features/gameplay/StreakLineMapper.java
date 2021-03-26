package myappaledone.myappale.features.gameplay;

import myappaledone.myappale.commons.Mapper;
import myappaledone.myappale.model.UsedWord;
import myappaledone.myappale.custom.StreakView;



public class StreakLineMapper extends Mapper<UsedWord.AnswerLine, StreakView.StreakLine> {
    @Override
    public StreakView.StreakLine map(UsedWord.AnswerLine obj) {
        StreakView.StreakLine s = new StreakView.StreakLine();
        s.getStartIndex().set(obj.startRow, obj.startCol);
        s.getEndIndex().set(obj.endRow, obj.endCol);
        s.setColor(obj.color);

        return s;
    }

    @Override
    public UsedWord.AnswerLine revMap(StreakView.StreakLine obj) {
        UsedWord.AnswerLine a = new UsedWord.AnswerLine();
        a.startRow = obj.getStartIndex().row;
        a.startCol = obj.getStartIndex().col;
        a.endRow = obj.getEndIndex().row;
        a.endCol = obj.getEndIndex().col;
        a.color = obj.getColor();

        return a;
    }
}
