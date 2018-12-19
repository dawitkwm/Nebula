 
package com.codebus.integration;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.TranData;

public interface TransactionDataTransformer {

	public MtsTranDataEnvelope transformTranData(TranData item);

}
