// ���߻���

$(document).ready(function(){
	$(".slider dd").hide();
	$(".slider dt").click(function(){
		// ���ﲻ����parent(),��Ϊparentֻ�����һ�������������ĸ�����dl,��dl�²��ҵ�dt�����Լ�����
		// parents�������һֱ�鵽���ҵ����Ƚڵ㣬���������ҵ��������������ֵ�dt,������ǵ�dt_action��ʽ,
		// ��������ǰ�������ʽ���������
		$(this).parents().find("dt").removeClass("dt_action");
		// removeclass()��addclass()��˳���ܻ�
		$(this).addClass("dt_action"); 
		$(this).parent().find("dd").removeClass("mymenu");
		$(".mymenu").slideUp();
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("mymenu");
		
		})
	})

function jiaojuan(){
		var flag = confirm("����֮ǰ����ȷ�����е���Ŀ����������???");
		if(flag){
			window.location.href = "${pageContext.request.contextPath }/ExamServlet?id=2";
		}else{
			return false;
		}
	}
	
	$(function(){
		setInterval("jishi()", 1000);
	})
	/* ���ÿ���ʱ����45���� */
	var maxTime = 60*45;
	function jishi(){
		if(maxTime>=0){ 
			var minutes = Math.floor(maxTime / 60);
			var seconds  = Math.floor(maxTime % 60);
			msg = "����ģ�⿼�Խ�������"+minutes+"��"+seconds+"��";  
			$("#span").html("<font color='red'>&nbsp;��ϰ����ʱ:&nbsp;</font>"+minutes+"��"+seconds+"��");
			/* �����Ե���ʱʣ��5����ʱ�������û�ʣ��ʱ�� */
			if( maxTime == 5*60){
				alert("��ģ�⿼�Խ���ʱ�仹��5���ӣ���ӽ�ʱ��������Ŀ");
			}
			--maxTime;
		}	
	}
