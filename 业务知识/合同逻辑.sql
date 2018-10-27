####工单查询
select * from t_lon_application ;
### 查询序列号
SELECT SEQ_NO+1 AS NEXT_VAL FROM T_SYS_CONTRACT_CODE t where SALE_CHANNEL=1;

select * from T_SYS_CONTRACT_CODE;
### 数据库承担了计算的压力
select @cnt:= seq_no+1 as NEXT_VAL from T_SYS_CONTRACT_CODE;

####开户行信息（这里面叫账户信息）
select * from t_lon_account;

####费用信息查询
 select  *  from t_loan_fee_info ；