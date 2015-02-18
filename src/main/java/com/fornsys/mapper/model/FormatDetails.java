package com.fornsys.mapper.model;

import java.io.Serializable;

public class FormatDetails {
	private RecordType recordType;
	private FamilyJoin familyJoin;
	
	public FormatDetails() { }
	
	public RecordType getRecordType() {
		return recordType;
	}
	
	public void setRecordType(RecordType type) {
		this.recordType = type;
	}
	
	public void setRecordType(String type) {
		this.recordType = RecordType.valueOf(type);
	}
	
	public FamilyJoin getFamilyJoin() {
		return familyJoin;
	}
	
	public void setFamilyJoin(FamilyJoin join) {
		this.familyJoin = join;
	}
	
	public enum RecordType {
		PerMember,
		PerSubscriber
	}
	
	public static class FamilyJoin implements Serializable {
		private static final long serialVersionUID = -2823787602587862529L;

		private FamilyJoinType joinType;
		private Integer subscriberFieldSub;
		private Integer subscriberFieldMem;
		
		public FamilyJoin(FamilyJoinType joinType) {
			this.joinType = joinType;
		}
		
		public Integer getSubscriberFieldSub() {
			return subscriberFieldSub;
		}
		
		public void setSubscriberFieldSub(Integer fieldOrdinal) {
			this.subscriberFieldSub = fieldOrdinal;
		}
		
		public Integer getSubscriberFieldMem() {
			return subscriberFieldMem;
		}
		
		public void setSubscriberFieldMem(Integer fieldOrdinal) {
			subscriberFieldMem = fieldOrdinal;
		}
		
		public FamilyJoinType getFamilyJoinType() {
			return joinType;
		}
		
		public enum FamilyJoinType {
			Sequential,
			SubscriberKey
		}
	}
}
