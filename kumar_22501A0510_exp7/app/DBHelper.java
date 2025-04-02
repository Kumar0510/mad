
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "student_grades";
    private static final String COLUMN_ROLL = "roll";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AVERAGE = "average";
    private static final String COLUMN_GRADE = "grade";
    private Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ROLL + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AVERAGE + " REAL, " +
                COLUMN_GRADE + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(int roll, String name, double average, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLL, roll);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AVERAGE, average);
        values.put(COLUMN_GRADE, grade);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean deleteStudent(int roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, COLUMN_ROLL + "=?", new String[]{String.valueOf(roll)});
        return result > 0;
    }

    public Cursor getStudent(int roll) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLL + "=?", new String[]{String.valueOf(roll)});
    }

    public boolean updateStudent(int roll, String name, double average, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AVERAGE, average);
        values.put(COLUMN_GRADE, grade);

        int result = db.update(TABLE_NAME, values, COLUMN_ROLL + "=?", new String[]{String.valueOf(roll)});
        return result > 0;
    }
}
