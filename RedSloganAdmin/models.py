from  django.db import models


class Image(models.Model):
    image_link = models.TextField(verbose_name= "image_link",help_text="图片链接")
    content_id = models.IntegerField(verbose_name="content_id",help_text="图片内容对应的表中元素id")
    content_type = models.CharField(max_length=255,verbose_name="content_type",help_text="图片内容对应的表名")
    class Meta():
        db_table='images'
        verbose_name="图片"
        verbose_name_plural=verbose_name


    def __str__(self):
        return self.image_link


class paperType(models.Model):
    type=models.CharField(max_length=255,verbose_name="type",help_text="文献检索一级类型")

    class Meta():
        db_table='paper_type'
        verbose_name="红色文献一级类型"
        verbose_name_plural=verbose_name

    def __str__(self):
        return self.type

class paperTypeLev2(models.Model):
    type=models.CharField(max_length=255,verbose_name="type",help_text="文献检索二级类型")
    class Meta():
        db_table='paper_type_lev2'
        verbose_name="红色文献二级类型"
        verbose_name_plural=verbose_name

    def __str__(self):
        return self.type
class Paper(models.Model):
    paper_name=models.CharField(max_length=255,verbose_name="paper_name",help_text="文献名字")
    paper_dir=models.CharField(max_length=10000,verbose_name="paper_dir",help_text="文献链接")
    type_id=models.ForeignKey(paperType,verbose_name="type_id",help_text="文献属于的一级类型id",db_column='type_id',on_delete=models.PROTECT)
    type_lev2_id=models.ForeignKey(paperTypeLev2,verbose_name="type_lev2_id",help_text="文献所属二级类型id",db_column='type_lev2_id',on_delete=models.PROTECT)

    class Meta():
        db_table='paper'
        verbose_name="红色文献"
        verbose_name_plural=verbose_name

class relicType(models.Model):
    type_name=models.CharField(max_length=255,verbose_name="type_name",help_text="文物类型")

    class Meta():
        db_table='relic_type'
        verbose_name="红色文物类型"
        verbose_name_plural=verbose_name

    def __str__(self):
        return self.type_name

class Relic(models.Model):
    introduction=models.CharField(max_length=10000,verbose_name="introduction",help_text="文献介绍")
    image_id_list=models.CharField(max_length=255,verbose_name="image_list",help_text="文物图片对应的id列表")
    type_id=models.ForeignKey(relicType,on_delete=models.PROTECT,verbose_name="type_id",help_text="文物类型id",db_column='type_id')
    relic_name=models.CharField(max_length=255,verbose_name="relic_name",help_text="文物名字")

    class Meta():
        db_table='relic'
        verbose_name="红色文物"
        verbose_name_plural=verbose_name

    def __str__(self):
        return self.image_id_list


class Fame(models.Model):
    intro=models.CharField(max_length=10000,verbose_name="intro",help_text="名人介绍")
    image_id_list = models.CharField(max_length=255, verbose_name="image_list", help_text="名人图片对应的id列表")
    fame_name=models.CharField(max_length=255,verbose_name="fame_name",help_text="名人名字")


    class Meta():
        db_table='resource_fame'
        verbose_name="名人"
        verbose_name_plural=verbose_name

    def __str__(self):
        return self.image_id_list


class Poetry(models.Model):
    content=models.CharField(max_length=500,verbose_name="content",help_text="红色诗歌内容")
    image_list=models.CharField(max_length=255,verbose_name="image_list",help_text="红色诗歌图片")
    annotation=models.CharField(max_length=500,verbose_name="annotaionm",help_text="红色诗歌注解")

    class Meta():
        db_table='resource_poetry'
        verbose_name="红色诗歌"
        verbose_name_plural=verbose_name
    def __str__(self):
        return self.image_list


class Slogan(models.Model):
    slogan_image_list=models.CharField(max_length=255,verbose_name="slogan_image_list",help_text="红色标语图片列表")
    intro=models.CharField(max_length=10000,verbose_name="intro",help_text="红色标语内容及介绍")

    class Meta():
        db_table='resource_slogan'
        verbose_name="红色标语"
        verbose_name_plural=verbose_name
    def __str__(self):
        return self.slogan_image_list

class Song(models.Model):
    song_name=models.CharField(max_length=255,verbose_name="song_name",help_text="红色歌曲名字")
    song_link=models.TextField(verbose_name="song_link",help_text="红色歌曲链接")
    opern_image_list=models.CharField(max_length=255,verbose_name="opern_image_list",help_text="红色歌曲乐谱图片列表")
    introduction=models.TextField(verbose_name="introduction.............................................",help_text="红色歌曲介绍",db_column='text')
    cover_image=models.TextField(verbose_name="cover_image",help_text="红色歌曲封面")

    class Meta():
        db_table='resource_song'
        verbose_name="红色歌曲"
        verbose_name_plural=verbose_name

