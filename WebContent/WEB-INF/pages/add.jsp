<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(".submit").click(function(){
			var cname = $("input[name='cname']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/customer/verify",
				type:"post",
				data:{cname:cname},
				dataType:"text",
				success:function(data){
					if(data!="true"){
						alert("客户名称错误");
					}else{
						$("form").submit();
					}
				}
			})
			return false;
		})
		$("select[name='pid']").change(function(){
			var pid = $(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/order/detail",
				type:"post",
				data:{pid:pid},
				dataType:"text",
				success:function(data){
					$("input[name='price']").val(data);
					$("input[name='number']").val(1);
					$("input[name='totalPrice']").val(data);
				}
			})
		})
		$("input[name='number']").change(function(){
			var number = $(this).val();
			var price = $("input[name='price']").val();
			$("input[name='totalPrice']").val(price*number);
		})
		$("input[name='save']").click(function(){
			var oid = $("select[name='pid']").val();
			var productNumber = $("input[name='number']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/orderLine/save",
				type:"post",
				data:{oid:oid,productNumber:productNumber},
				dataType:"text",
				success:function(data){
					if(data!="success"){
						alert("保存失败");
					}else{
						$("input[name='save']").val("删除");
					}
				}
			})
		})
	})
</script>
</head>
<body>
	<h2>您当前的位置:销售管理>添加订单</h2>
	<form action="${pageContext.request.contextPath }/order/addOrder" method="post">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>订单编号</td>
				<td><input type="text" name="id" value="${requestScope.id }" readonly="readonly"></td>
				<td>下单日期</td>
				<td><input type="text" name="orderDate1" value="<f:formatDate value="${requestScope.orderDate }" pattern="yyyy-MM-dd"/>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>客户名称</td>
				<td><input type="text" name="cname" value="${requestScope.order.cname }"></td>
				<td>送货时间</td>
				<td><input type="text" name="deliverDate1" value="<f:formatDate value="${requestScope.order.deliverDate}" pattern="yyyy-MM-dd"/>"></td>
			</tr>
			<tr>
				<td>送货地址</td>
				<td colspan="3"><input type="text" name="address" width="40px" value="${requestScope.order.address }"></td>
			</tr>
		</table>
		<c:if test="${!empty requestScope.products }">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<td>产品名称</td>
					<td>单价</td>
					<td>数量</td>
					<td>总价</td>
					<td>操作</td>
				</tr>
				<tr>
					<td>
						<select name="pid">
							<option>请选择</option>
							<c:forEach items="${requestScope.products }" var="product">
								<option value="${product.id }">${product.name }</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="text" name="price" readonly="readonly"></td>
					<td><input type="text" name="number"></td>
					<td><input type="text" name="totalPrice" readonly="readonly"></td>
					<td><input type="button" name="save" value="保存订单行"></td>
				</tr>
			</table>
		</c:if>
		<br/>
		<div align="center" style="width: 40%">
			<input type="submit" value="保存" class="submit">&nbsp;&nbsp;
			<input type="button" value="提交">
		</div>
	</form>
</body>
</html>