package database.CrimeDbSchema;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.administrator.criminalintent.Crime;

import java.util.Date;
import java.util.UUID;

import database.CrimeDbSchema.CrimeDbSchema.CrimeTable;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);

        return crime;
    }

}
