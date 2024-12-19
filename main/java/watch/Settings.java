package watch;

import necesse.engine.modLoader.ModSettings;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class Settings extends ModSettings {
    public boolean milttime = false;

    @Override
    public void addSaveData(SaveData save) {
        save.addBoolean("military_time", milttime,"Switch between 12-hour and 24-hour time format.\n                             //false = 12-hour time format.\n                             //true = 24-hour time format.");
    }

    @Override
    public void applyLoadData(LoadData save) {
        if (save == null)
            return;
        milttime = save.getBoolean("military_time");
    }


}