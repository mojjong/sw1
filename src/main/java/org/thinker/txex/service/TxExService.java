package org.thinker.txex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thinker.txex.mapper.TxExMapper;


//서비스에선 이런 방식이 맞다. 하지만 어노테이션을 걸고 싶다면 root-context.xml에 추가설정이 필요하다.
@Service
//@Transactional
public class TxExService {

	@Inject
	TxExMapper mapper;
	
	@Transactional(propagation=Propagation.REQUIRED) //메소드 단위로 트랜잭션 처리하고 싶을때.
	public void addData(String codeValue, String strValue)throws Exception{
		
		mapper.insertMain(codeValue);
		
		mapper.insertSub(strValue);
		
	}
	
	public void updateData(Integer num, String value)throws Exception{
		
		
		mapper.insertMain(value);
		
		mapper.update1(num, value);
		
		
	}
	
	
	
}
