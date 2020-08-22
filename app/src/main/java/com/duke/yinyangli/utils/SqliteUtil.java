package com.duke.yinyangli.utils;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SqliteUtil {

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * */
    public static void copyDataBase(Context context, String dbname) throws IOException {
        // Open your local db as the input stream
        InputStream myInput = context.getAssets().open(dbname);

        // Path to the just created empty db
        File outFileName = context.getDatabasePath(dbname);

        if (!outFileName.exists()) {
            outFileName.getParentFile().mkdirs();

            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;

            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
    }
}
