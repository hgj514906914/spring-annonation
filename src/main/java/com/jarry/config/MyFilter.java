package com.jarry.config;

import java.io.IOException;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		ClassMetadata cm = metadataReader.getClassMetadata();
		if(cm.getClassName().contains("Dao")) {
			return true ;
		}else {
			return false;// false ≤ª∆•≈‰  true ∆•≈‰  
		}
		
	}

}
