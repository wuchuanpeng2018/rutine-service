User user = new User();
user.setUsername(userDTO.getUsername());
user.setAge(userDTO.getAge());

1:使用工具
User user = new User();
BeanUtils.copyProperties(userInputDTO,user);