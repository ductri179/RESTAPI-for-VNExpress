package com.oscartran.restful_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import com.oscartran.restful_api.entities.CustomSequences;

@Service
public class NextSequenceService {

	@Autowired
	private MongoOperations mongo;
	
	public Long getNextSequence(String seqName) {
		
		CustomSequences counter = mongo.findAndModify(
	            query(where("_id").is(seqName)),
	            new Update().inc("seq",1),
	            options().returnNew(true).upsert(true),
	            CustomSequences.class);
		
		return counter.getSeq();
	}
	
	public void reset() {
		mongo.dropCollection(CustomSequences.class);
	}
	
}
