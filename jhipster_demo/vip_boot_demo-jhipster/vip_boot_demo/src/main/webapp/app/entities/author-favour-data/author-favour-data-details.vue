<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="authorFavourData">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.authorFavourData.detail.title')">AuthorFavourData</span> {{authorFavourData.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.authorFavourData.userId')">User Id</span>
                    </dt>
                    <dd>
                        <span>{{authorFavourData.userId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.authorFavourData.createDate')">Create Date</span>
                    </dt>
                    <dd>
                        <span v-if="authorFavourData.createDate">{{$d(Date.parse(authorFavourData.createDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.authorFavourData.author')">Author</span>
                    </dt>
                    <dd>
                        <div v-if="authorFavourData.authorId">
                            <router-link :to="{name: 'AuthorView', params: {authorId: authorFavourData.authorId}}">{{authorFavourData.authorId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="authorFavourData.id" :to="{name: 'AuthorFavourDataEdit', params: {authorFavourDataId: authorFavourData.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./author-favour-data-details.component.ts">
</script>
