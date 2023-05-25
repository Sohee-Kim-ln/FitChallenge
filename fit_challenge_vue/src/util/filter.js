export default {
  sportsFilter(value) { 
    switch (Number(value)) {
      case 1:
        return "등산";
      case 2:
        return "러닝";
      case 3:
        return "수영";
      case 4:
        return "자전거";
      case 5:
        return "헬스";
    }
  },
  genderFilter(value){
    switch(value){
        case 0:return"남성";
        case 1:return"여성";
        case 2:return"선택안함";
    }
  },
  archieveFilter(value){
    return value+"%";
  },
  timeFilter(value){
    return value+"시간";
  },
  distFilter(value){
    return value+"m";
  },
  commentFilter(value){
    if(value===null)
    return "코멘트가 없습니다";
    else if(value==="null")
    return "코멘트가 없습니다"
    else return value;
  }

};
