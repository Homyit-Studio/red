
from django.contrib import admin
from django.utils.html import format_html, format_html_join

from RedSloganAdmin.models import Image, Paper, paperType, paperTypeLev2, relicType, Relic, Fame, Poetry, Slogan, Song


@admin.register(Image)
class ImageAdmin(admin.ModelAdmin):
    list_display = ('id','image_tag','image_link','content_id','content_type')
    search_fields = ('content_type',)
    ordering = ('id',)
    def image_tag(self,obj):
        return format_html('<img src="{}" width="100" height="100" />'.format(obj.image_link))
    image_tag.short_description='image'

@admin.register(Paper)
class PaperAdmin(admin.ModelAdmin):
    list_display = ('id','paper_name','paper_dir','type_id','type_lev2_id')
    search_fields = ('paper_name','type_id','type_lev2_id',)
    ordering = ('id',)


@admin.register(paperType)
class PaperTypeAdmin(admin.ModelAdmin):
    list_display = ('id','type')
    ordering = ('id',)

@admin.register(paperTypeLev2)
class PaperTypeLev2Admin(admin.ModelAdmin):
    list_display = ('id','type')
    ordering = ('id',)


@admin.register(relicType)
class RelicTypeAdmin(admin.ModelAdmin):
    list_display = ('id','type_name')
    ordering = ('id',)

@admin.register(Relic)
class RelicAdmin(admin.ModelAdmin):
    list_display = ('id','relic_name','introduction','image_list','type')
    search_fields = ('relic_name','type_id',)
    ordering = ('id',)

    def image_list(self,obj):
       ids=obj.image_id_list.split(',')
       links=Image.objects.filter(id__in=ids)
       return format_html_join('','<img src="{}" width="100" height="100" style="margin-right: 10px;" />',  ((link,)for link in links))

    def type(self,obj):
        return obj.type_id



@admin.register(Fame)
class FameAdmin(admin.ModelAdmin):
    list_display = ('id','fame_name','intro','image_list')
    search_fields = ('fame_name',)
    ordering = ('id',)

    def image_list(self,obj):
       ids=obj.image_id_list.split(',')
       links=Image.objects.filter(id__in=ids)
       return format_html_join('','<img src="{}" width="100" height="100" style="margin-right: 10px;" />',  ((link,)for link in links))



@admin.register(Poetry)
class PoetryAdmin(admin.ModelAdmin):
    list_display = ('id','content','images','annotation')
    search_fields = ('content',)
    ordering = ('id',)
    def images(self,obj):
        ids = obj.image_list.split(',')
        links = Image.objects.filter(id__in=ids)
        return format_html_join('', '<img src="{}" width="100" height="100" style="margin-right: 10px;" />',
                                ((link,) for link in links))

@admin.register(Slogan)
class SloganAdmin(admin.ModelAdmin):
    list_display = ('id','image_list','intro')
    search_fields = ('intro',)
    ordering = ('id',)

    def image_list(self,obj):
        ids = obj.slogan_image_list.split(',')
        links = Image.objects.filter(id__in=ids)
        return format_html_join('', '<img src="{}" width="100" height="100" style="margin-right: 10px;" />',
                                ((link,) for link in links))


@admin.register(Song)
class SongAdmin(admin.ModelAdmin):
    list_display = ('id','song_name','song_link','opern_image_list','introduction','cover_image')
    search_fields = ('song_name',)
    ordering = ('id',)






