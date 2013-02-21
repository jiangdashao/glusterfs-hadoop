package org.gluster.test;

import java.io.File;

import junit.framework.Assert;

import org.apache.hadoop.fs.glusterfs.FileInfoUtil;
import org.apache.tools.ant.types.FlexInteger;
import org.junit.Test;

public class TestFileInfo {

	//TODO ~ also add gluster file system tests to test that
	//the filesystem getStatus utilizes this information correctly.
	@Test
	public void test() throws Exception {
		String user=System.getProperties().getProperty("user.name");
		File f = File.createTempFile("tempjunit", ".tmp");
		String owner=FileInfoUtil.getLSinfo(f.getAbsolutePath()).get("owner");
		System.out.println("Confirming -- \nuser.name(" + user +")=owner("+owner+")");
		Assert.assertEquals(user,owner);
	}

	
	@Test
	public void test2(){

		String t = "drwxr-xr-x 2 root root 8198 Feb 21 20:29 ./";
		String[] vals = t.split("\\s+");
		for(int i = 0 ; i < vals.length; i++){
			System.out.println(i + " " + vals[i]);
		}
	}
}

