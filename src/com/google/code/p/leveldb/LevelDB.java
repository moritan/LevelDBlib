package com.google.code.p.leveldb;

import java.io.File;

import android.content.Context;

public class LevelDB {
	String mDBdir;
	
	static {
		System.loadLibrary("leveldb");
	}

	public LevelDB(Context context) {
		   mDBdir = context.getFilesDir().getAbsolutePath() + File.separator+"db" ;
			new File(mDBdir).mkdirs();
	}
	
	public String open(){
		return this.dbOpen(mDBdir);
	}
	public String close(){
		return this.dbClose(mDBdir);
	}
	
	/*
	 * Methods which wrap LevelDB calls, see jni/main.cc for details
	 */
	private native String dbOpen(String dbpath);

	private native String dbClose(String dbpath);

	public native String dbPut(String key1, String value1);

	public native String dbGet(String key1);
	
	public native String dbDelete(String key1);

	/*
	 * A native method that is implemented by the 'hello-jni' native library,
	 * which is packaged with this application.
	 */
	public native String stringFromJNI();

	/*
	 * this is used to load the 'leveldb' library on application startup. The
	 * library has already been unpacked into
	 * /data/data/com.example.HelloJni/lib/libleveldb.so at installation time by
	 * the package manager.
	 */

}
