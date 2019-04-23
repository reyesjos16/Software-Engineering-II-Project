var arr = ['@',';','&','#','$','%','^','&','*','(',')','.','-','+','=','_','/',',','<','>','0','1','2','3','4','5','6','7','8','9'];
var emailchar = ['$','!',';','&','#','%','^','&','*','(',')','+','=','/',',','<','>','?'];
var nums = ['0','1','2','3','4','5','6','7','8','9'];
function validatename(name){
    // v='abc'
    var val = name
    var result = true;
    
    if(val==""){
        result = false
        
    }else{
   
        for(var i=0;i<arr.length;i++){
            if(val.indexOf(emailchar[i])!= -1){
                result = false;
                break;
            }
        }
    }
    return result;
}

function validatemail(mail){
    
    if(mail==""){
        return false
    }else{
        var m=mail.split('@');
        if(m.length!=2){
            return false
        }else
        {
            var result= true
            if(m[0].length==0 || m[1].length==0){
                return false;
            }else{
                var frs = m[0].charAt(0);
                
                if(frs == " "|| !isNaN(frs)){
                    return false
                }
                frs=m[1]
                
                if(frs == " "|| !isNaN(frs)){
                    return false
                }
                if(m[0].indexOf('..')!=-1 || m[1].indexOf('..')!=-1 || m[0].indexOf('-')!=-1 ){
                    return false
                }
                if(m[1].indexOf['.'] == -1){
                    return false
                }
                var len = frs.length-1
                for(var i=0;i<emailchar.length;i++){
                    if((m[0].indexOf(emailchar[i])!= -1) || (m[1].indexOf(emailchar[i])!= -1)){
                        result = false;
                        break;
                    }
                }
                for(var i=0;i<nums.length;i++){
                    if((m[1].indexOf(nums[i])!= -1)){
                        result = false;
                        break;
                    }
                }
                if(frs.charAt(len) == '.' || frs.charAt(0) == '.' ){
                    return false
                }
                if(m[1].indexOf('.')!=-1){
                    return true;
                }
                
            }
            return result;
        }
    }
}
